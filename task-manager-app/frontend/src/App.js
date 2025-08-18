import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { TaskProvider } from "./context/TaskContext";
import ErrorBoundary from "./components/ErrorBoundary";
import Navigation from "./components/Navigation";
import TaskList from "./components/TaskList";
import CreateTask from "./components/CreateTask";
import EditTask from "./components/EditTask";
import TaskManager from "./components/TaskManager";

import "./App.css";
function App() {
  return (
    <ErrorBoundary>
      <TaskProvider>
        <Router>
          <div className="App">
            <header
              style={{
                backgroundColor: "#343a40",
                color: "white",
                padding: "20px",
              }}
            >
              <h1>Task Manager App</h1>
              <TaskManager/>
            </header>
            <Navigation />
            <main>
              <Routes>
                <Route path="/" element={<TaskList />} />
                <Route path="/create" element={<CreateTask />} />
                <Route path="/edit/:id" element={<EditTask />} />
              </Routes>
            </main>
          </div>
        </Router>
      </TaskProvider>
    </ErrorBoundary>
  );
}
export default App;
