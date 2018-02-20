const {
    Environment,
    Network,
    RecordSource,
    Store,
  } = require('relay-runtime');
  
const SubscriptionClient = require('subscriptions-transport-ws');

const store = new Store(new RecordSource());
  
const fetchQuery = (operation, variables) => {
    return fetch('http://localhost:4000/graphql', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            query: operation.text,
            variables,
        }),
    }).then(response => {
        return response.json();
    })
};

const setupSubscription = (config, variables, cacheConfig, observer) => {
    const query = config.text;
  
    const subscriptionClient = new SubscriptionClient('ws://localhost:4000/subscriptions', 
                                                        {reconnect: true})
    subscriptionClient.subscribe({query, variables}, (error, result) => {
      observer.onNext({data: result});
    })
  };

const network = Network.create(fetchQuery, setupSubscription);

const environment = new Environment({
    network,
    store,
});
  
export default environment;