// --- Frontend: src/App.js ---
import React, { useState, useEffect } from "react";
import {
  Truck,
  Container as LucideContainer,
  Ship,
  PlusCircle,
  Search,
} from "lucide-react";
import axios from "axios";

const Containers = () => {
  const [containers, setContainers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [editingContainer, setEditingContainer] = useState(null);

  const [newContainer, setNewContainer] = useState({
    containerType: "",
    origin: "",
    destination: "",
    owner: "",
  });

  const fetchContainers = async () => {
    try {
      const response = await fetch("http://localhost:9090/api/containers");
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const data = await response.json();
      setContainers(data);
    } catch (e) {
      console.error("Failed to fetch containers:", e);
      setError("Failed to load containers. Please check the backend.");
    } finally {
      setLoading(false);
    }
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewContainer((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:9090/api/containers/add", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(newContainer),
      });
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      await fetchContainers();
      setNewContainer({
        containerType: "",
        origin: "",
        destination: "",
        owner: "",
      });
    } catch (e) {
      console.error("Failed to add container:", e);
      setError("Failed to add new container. Please check the backend.");
    }
  };

  const handleUpdate = async (e) => {
    e.preventDefault();
    try {
      await axios.put(
        `http://localhost:8080/api/containers/${editingContainer.id}`,
        newContainer
      );
      await fetchContainers();
      setEditingContainer(null);
      setNewContainer({
        containerType: "",
        origin: "",
        destination: "",
        owner: "",
      });
    } catch (error) {
      console.error("Failed to update container:", error);
      setError("Failed to update container. Please check the backend.");
    }
  };

  const handleDelete = async (id) => {
    if (window.confirm(`Are you sure you want to delete this: ${id}?`)) {
      try {
        await axios.delete(`http://localhost:8080/api/containers/${id}`);
        console.log("ID: ", id);
        const newContainers = containers.filter((task) => task.id !== id);
        setContainers(newContainers);
      } catch (error) {
        console.error(`Error deleting: ${error}`);
      }
    }
  };

  const handleEdit = (container) => {
    setEditingContainer(container);
    setNewContainer(container);
  };

  const filteredContainers = containers.filter(
    (container) =>
      container.containerType
        .toLowerCase()
        .includes(searchTerm.toLowerCase()) ||
      container.origin.toLowerCase().includes(searchTerm.toLowerCase()) ||
      container.destination.toLowerCase().includes(searchTerm.toLowerCase())
  );

  useEffect(() => {
    fetchContainers();
  }, []);

  if (loading)
    return (
      <div className="text-center mt-8 text-2xl font-bold text-gray-700 animate-pulse">
        Loading containers...
      </div>
    );
  if (error)
    return (
      <div className="text-center mt-8 text-2xl text-red-600 font-bold">
        {error}
      </div>
    );

  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-50 to-indigo-100 p-8 font-inter text-gray-800">
      <div className="max-w-7xl mx-auto">
        <header className="flex items-center justify-center space-x-4 mb-12">
          <Truck size={48} className="text-blue-600 animate-bounce" />
          <h1 className="text-5xl font-extrabold text-gray-900 drop-shadow-md">
            Cargo Management Dashboard
          </h1>
        </header>

        <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
          {/* New Container Form Section */}
          <div className="md:col-span-1 bg-white p-6 rounded-3xl shadow-2xl border-2 border-blue-200">
            <h2 className="flex items-center space-x-2 text-2xl font-bold text-blue-700 mb-6">
              <PlusCircle size={24} />
              <span>Add New Container</span>
            </h2>
            <form onSubmit={handleSubmit} className="space-y-4">
              <div>
                <label className="block text-sm font-medium text-gray-600">
                  Container Type
                </label>
                <input
                  type="text"
                  name="containerType"
                  value={newContainer.containerType}
                  onChange={handleInputChange}
                  required
                  className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-blue-500 focus:ring-blue-500 transition-colors"
                />
              </div>
              <div>
                <label className="block text-sm font-medium text-gray-600">
                  Origin
                </label>
                <input
                  type="text"
                  name="origin"
                  value={newContainer.origin}
                  onChange={handleInputChange}
                  required
                  className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-blue-500 focus:ring-blue-500 transition-colors"
                />
              </div>
              <div>
                <label className="block text-sm font-medium text-gray-600">
                  Destination
                </label>
                <input
                  type="text"
                  name="destination"
                  value={newContainer.destination}
                  onChange={handleInputChange}
                  required
                  className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-blue-500 focus:ring-blue-500 transition-colors"
                />
              </div>
              <div>
                <label className="block text-sm font-medium text-gray-600">
                  Owner
                </label>
                <input
                  type="text"
                  name="owner"
                  value={newContainer.owner}
                  onChange={handleInputChange}
                  required
                  className="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-blue-500 focus:ring-blue-500 transition-colors"
                />
              </div>
              {editingContainer ? (
                <button
                  type="button"
                  onClick={handleUpdate}
                  className="w-full flex items-center justify-center space-x-2 py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-green-600 hover:bg-green-700"
                >
                  <span>Update Container</span>
                </button>
              ) : (
                <button
                  type="submit"
                  className="w-full flex items-center justify-center space-x-2 py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-blue-600 hover:bg-blue-700"
                >
                  <span>Add Container</span>
                  <LucideContainer size={18} />
                </button>
              )}
            </form>
          </div>

          {/* Container List Section */}
          <div className="md:col-span-2 bg-white p-6 rounded-3xl shadow-2xl border-2 border-indigo-200">
            <div className="flex justify-between items-center mb-6">
              <h2 className="flex items-center space-x-2 text-2xl font-bold text-indigo-700">
                <Ship size={24} />
                <span>Containers on the Ship</span>
              </h2>
              <div className="relative">
                <input
                  type="text"
                  placeholder="Search containers..."
                  value={searchTerm}
                  onChange={(e) => setSearchTerm(e.target.value)}
                  className="pl-10 pr-4 py-2 rounded-full border border-gray-300 focus:ring-indigo-500 focus:border-indigo-500"
                />
                <Search
                  className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400"
                  size={18}
                />
              </div>
            </div>

            {filteredContainers.length === 0 ? (
              <p className="text-gray-500 italic text-center">
                No containers match your search or have been added yet.
              </p>
            ) : (
              <ul className="space-y-4">
                {filteredContainers.map((container) => (
                  <li
                    key={container.id}
                    className="bg-gray-50 border-l-4 border-indigo-500 rounded-xl p-4 shadow-sm transition-all hover:bg-indigo-50"
                  >
                    <div className="flex flex-col sm:flex-row justify-between items-start sm:items-center">
                      <div className="flex-1">
                        <p className="text-lg font-bold text-indigo-800">
                          Container ID:{" "}
                          <span className="font-normal text-gray-700">
                            {container.id}
                          </span>
                        </p>
                        <p className="text-gray-600 text-sm mt-1">
                          From{" "}
                          <span className="font-medium text-indigo-600">
                            {container.origin}
                          </span>{" "}
                          to{" "}
                          <span className="font-medium text-indigo-600">
                            {container.destination}
                          </span>
                        </p>
                        <p className="text-gray-600 text-sm">
                          Owner:{" "}
                          <span className="font-medium">{container.owner}</span>
                        </p>
                      </div>
                      <div className="mt-2 sm:mt-0">
                        {container.isStacked ? (
                          <span className="inline-flex items-center rounded-full bg-green-100 px-3 py-1 text-xs font-semibold text-green-700">
                            Stacked at {container.stackLocation}
                          </span>
                        ) : (
                          <span className="inline-flex items-center rounded-full bg-yellow-100 px-3 py-1 text-xs font-semibold text-yellow-700 animate-pulse">
                            Pending Stack
                          </span>
                        )}
                      </div>
                      <div className="bg-yellow-500 px-[1rem] py-[.5rem] rounded-md ml-[1rem]">
                        <button
                          className="text-white cursor-pointer"
                          type="button"
                          onClick={() => handleEdit(container)}
                        >
                          Edit
                        </button>
                      </div>
                      <div className=" bg-red-500 px-[1rem] py-[.5rem] rounded-md ml-[1rem]">
                        <button
                          className="text-white cursor-pointer"
                          type="button"
                          onClick={() => handleDelete(container.id)}
                        >
                          Delete
                        </button>
                      </div>
                    </div>
                  </li>
                ))}
              </ul>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Containers;
