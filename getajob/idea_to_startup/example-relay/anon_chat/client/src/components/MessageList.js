import React, {Component} from 'react';
import {createFragmentContainer, graphql} from 'react-relay';
import Message from './Message';

class MessageList extends Component{

    componentWillMount(){
        console.log(this.props);
    }

    render() {
        return (
            <div>
                {this.props.messages.map((x) =>
                    <Message message={x.text} key={x.id}/>
                )}
            </div>
        )
    }
};

export default MessageList;