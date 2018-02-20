import {
    graphql,
    requestSubscription
  } from 'react-relay'
  import environment from '../Environment'
  
  const newMessageAddedSubscription = graphql`
    subscription NewMessageAddedSubscription {
      messageAdded{
          id
          text
      }
    }
  `

  export default () => {
  
    const subscriptionConfig = {
      subscription: newMessageAddedSubscription,
      variables: {},
      updater: proxyStore => {
        const createMessageField = proxyStore.getRootField('messageAdded')
        const newMessage = createMessageField.getValue('text')
        const newMessageId = createMessageField.getValue('id')
      },
      onError: error => console.log(`An error occured:`, error)
    }
  
    requestSubscription(
      environment,
      subscriptionConfig
    )
  
  }