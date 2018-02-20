import{
    commitMutation,
    graphql
} from 'react-relay';
import {ConnectionHandler} from 'relay-runtime';
import environment from '../Environment';

const mutation = graphql`
    mutation CreateMessageMutation($input: String!) {
        addMessage(text: $input){
            id
            text
        }
    }
`

export default (text, callback) => {

  const variables = {
      input: text
  }

  commitMutation(
    environment,
    {
      mutation,
      variables,
      onCompleted: () => {
        callback()
      },
      onError: err => console.error(err),
    },
  )
}