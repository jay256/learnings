import React, { Component } from 'react';
import './App.css';
import MessageListPage from './components/MessageListPage'; 
import CreateMessage from './components/CreateMessage';

class App extends Component {
  render() {
    return (
      <div>
        <MessageListPage />
        <CreateMessage />
      </div>
    );
  }
}

export default App;