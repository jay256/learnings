
import { messages } from './query';
import { PubSub } from 'graphql-subscriptions';
import { Message } from '../models';

const pubsub = new PubSub();

const MESSAGE_ADDED_TOPIC = 'messageadded';

const resolvers = {
	Query: {
		messages
	},
	Mutation: {
		addMessage: (root, args) => {
			const newMessage = {
			  id: Message.length + 1,
			  text: args.text,
			}
			Message.push(newMessage);
			pubsub.publish(MESSAGE_ADDED_TOPIC, { messageAdded: newMessage });
			return newMessage;
		}
	},
	Subscription: {
		messageAdded: {
			subscribe: () => pubsub.asyncIterator(MESSAGE_ADDED_TOPIC)
		}
	}
};

export default resolvers;