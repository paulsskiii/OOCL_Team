import React from 'react'
import TaskList from "./components/TaskList";
import "./App.css";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Task Manager</h1>
        <p>Full-stack application with Spring Boot and React</p>
      </header>
      <main>
        <TaskList />
      </main>
    </div>
  );
}

export default App;
