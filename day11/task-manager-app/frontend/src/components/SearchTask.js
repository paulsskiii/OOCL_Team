import { useState } from "react";
import { taskService } from "../api/taskService";

export const SearchTask = ({ setSearchTasks }) => {
    const [keyword, setKeyword] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await taskService.searchTask(keyword);
            setSearchTasks(response.data);  // axios responses have data
        } catch (error) {
            console.error("Search failed:", error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                name="keyword"
                value={keyword}
                onChange={(e) => setKeyword(e.target.value)}
            />
            <button
                type="submit"
                style={{
                    padding: "5px 10px",
                    marginLeft: "10px",
                    backgroundColor: "#007bff",
                    color: "white",
                    border: "none",
                }}
            >
                Search
            </button>
        </form>
    );
};
