import {
    makeExecutableSchema,
  } from 'graphql-tools';
import resolvers from './resolvers';  
  const typeDefs = `

  type Message {
    id: ID!
    text: String!
  }

  type Query {
    messages: [Message]
  }

  type Mutation {
    addMessage(text: String!): Message
  }

  type Subscription {
    messageAdded: Message
  }

`;
  const schema = makeExecutableSchema({ typeDefs, resolvers });
  export { schema };