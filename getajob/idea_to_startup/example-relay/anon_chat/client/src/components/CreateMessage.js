import React, {Component} from 'react';
import CreateMessageMutation from '../mutations/CreateMessageMutation';

export default class CreateMessage extends Component{
    
    state = {
        text : ''
    }

    render(){
        return(
            <div>
                <div className='flex flex-column mt3'>
                    <input
                        className='mb2'
                        value={this.state.text}
                        onChange={(e) => this.setState({text:e.target.value})}
                        placeholder='Add a new message'
                    />
                </div>
                <div
                    className='button'
                    onClick={() => this._createMessage()}
                >
                    Send
                </div>
            </div>
        );
    }

    _createMessage= () => {
        const text = this.state.text;
        if(text !== '')
            CreateMessageMutation(text, () => console.log("Message added "+text));
    }

}