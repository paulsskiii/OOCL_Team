import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { TaskProvider } from "./frontend/src/context/TaskContext";
import ErrorBoundary from "./frontend/src/components/ErrorBoundary";
import Navigation from "./frontend/src/components/Navigation";
import TaskList from "./frontend/src/components/TaskList";
import CreateTask from "./frontend/src/components/CreateTask";
import EditTask from "./frontend/src/components/EditTask";
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