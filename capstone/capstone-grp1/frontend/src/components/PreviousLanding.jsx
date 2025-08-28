// --- Frontend: src/App.js ---
import React, { useState, useEffect } from "react";
import {
	Truck,
	Container as LucideContainer,
	Ship,
	PlusCircle,
	Search,
} from "lucide-react";

// API URL for the Spring Boot backend
const API_URL = "http://localhost:8080/api/containers";

const PreviousLanding = () => {
	const [containers, setContainers] = useState([]);
	const [loading, setLoading] = useState(false); //turn back to true after finishing frontend and integration
	const [error, setError] = useState(null);
	const [searchTerm, setSearchTerm] = useState("");

	// State for the new container form
	const [newContainer, setNewContainer] = useState({
		containerNumber: "",
		origin: "",
		destination: "",
		weightKg: "",
	});

	// Fetch container data from the backend API
	const fetchContainers = async () => {
		try {
			const response = await fetch(API_URL);
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

	// Handler for form input changes
	const handleInputChange = (e) => {
		const { name, value } = e.target;
		setNewContainer((prev) => ({ ...prev, [name]: value }));
	};

	// Handler for form submission
	const handleSubmit = async (e) => {
		e.preventDefault();
		try {
			const response = await fetch(API_URL, {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(newContainer),
			});
			if (!response.ok) {
				throw new Error(`HTTP error! status: ${response.status}`);
			}
			// Re-fetch containers to update the list
			await fetchContainers();
			// Reset the form
			setNewContainer({
				containerNumber: "",
				origin: "",
				destination: "",
				weightKg: "",
			});
		} catch (e) {
			console.error("Failed to add container:", e);
			setError("Failed to add new container. Please check the backend.");
		}
	};

	// Filtered containers based on search term
	const filteredContainers = containers.filter(
		(container) =>
			container.containerNumber
				.toLowerCase()
				.includes(searchTerm.toLowerCase()) ||
			container.origin.toLowerCase().includes(searchTerm.toLowerCase()) ||
			container.destination.toLowerCase().includes(searchTerm.toLowerCase())
	);

	// Initial data fetch on component mount
	useEffect(() => {
		// fetchContainers();
	}, []);

	if (loading)
		return (
			<div className="mt-8 text-2xl font-bold text-center text-gray-700 animate-pulse">
				Loading containers...
			</div>
		);
	if (error)
		return (
			<div className="mt-8 text-2xl font-bold text-center text-red-600">
				{error}
			</div>
		);

	return (
		<div className="min-h-screen p-8 text-gray-800 bg-gradient-to-br from-blue-50 to-indigo-100 font-inter">
			<div className="mx-auto max-w-7xl">
				<header className="flex items-center justify-center mb-12 space-x-4">
					<Truck size={48} className="text-blue-600 animate-bounce" />
					<h1 className="text-5xl font-extrabold text-gray-900 drop-shadow-md">
						Cargo Management Dashboard
					</h1>
				</header>

				<div className="grid grid-cols-1 gap-8 md:grid-cols-3">
					{/* New Container Form Section */}
					<div className="p-6 bg-white border-2 border-blue-200 shadow-2xl md:col-span-1 rounded-3xl">
						<h2 className="flex items-center mb-6 space-x-2 text-2xl font-bold text-blue-700">
							<PlusCircle size={24} />
							<span>Add New Container</span>
						</h2>
						<form onSubmit={handleSubmit} className="space-y-4">
							<div>
								<label className="block text-sm font-medium text-gray-600">
									Container Number
								</label>
								<input
									type="text"
									name="containerNumber"
									value={newContainer.containerNumber}
									onChange={handleInputChange}
									required
									className="block w-full mt-1 transition-colors border-gray-300 rounded-md shadow-sm focus:border-blue-500 focus:ring-blue-500"
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
									className="block w-full mt-1 transition-colors border-gray-300 rounded-md shadow-sm focus:border-blue-500 focus:ring-blue-500"
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
									className="block w-full mt-1 transition-colors border-gray-300 rounded-md shadow-sm focus:border-blue-500 focus:ring-blue-500"
								/>
							</div>
							<div>
								<label className="block text-sm font-medium text-gray-600">
									Weight (kg)
								</label>
								<input
									type="number"
									name="weightKg"
									value={newContainer.weightKg}
									onChange={handleInputChange}
									required
									className="block w-full mt-1 transition-colors border-gray-300 rounded-md shadow-sm focus:border-blue-500 focus:ring-blue-500"
								/>
							</div>
							<button
								type="submit"
								className="flex items-center justify-center w-full px-4 py-2 space-x-2 text-sm font-medium text-white transition-colors bg-blue-600 border border-transparent rounded-md shadow-sm hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500"
							>
								<span>Add Container</span>
								<LucideContainer size={18} />
							</button>
						</form>
					</div>

					{/* Container List Section */}
					<div className="p-6 bg-white border-2 border-indigo-200 shadow-2xl md:col-span-2 rounded-3xl">
						<div className="flex items-center justify-between mb-6">
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
									className="py-2 pl-10 pr-4 border border-gray-300 rounded-full focus:ring-indigo-500 focus:border-indigo-500"
								/>
								<Search
									className="absolute text-gray-400 -translate-y-1/2 left-3 top-1/2"
									size={18}
								/>
							</div>
						</div>

						{filteredContainers.length === 0 ? (
							<p className="italic text-center text-gray-500">
								No containers match your search or have been added yet.
							</p>
						) : (
							<ul className="space-y-4">
								{filteredContainers.map((container) => (
									<li
										key={container.id}
										className="p-4 transition-all border-l-4 border-indigo-500 shadow-sm bg-gray-50 rounded-xl hover:bg-indigo-50"
									>
										<div className="flex flex-col items-start justify-between sm:flex-row sm:items-center">
											<div className="flex-1">
												<p className="text-lg font-bold text-indigo-800">
													Container ID:{" "}
													<span className="font-normal text-gray-700">
														{container.containerNumber}
													</span>
												</p>
												<p className="mt-1 text-sm text-gray-600">
													From{" "}
													<span className="font-medium text-indigo-600">
														{container.origin}
													</span>{" "}
													to{" "}
													<span className="font-medium text-indigo-600">
														{container.destination}
													</span>
												</p>
												<p className="text-sm text-gray-600">
													Weight:{" "}
													<span className="font-medium">
														{container.weightKg} kg
													</span>
												</p>
											</div>
											<div className="mt-2 sm:mt-0">
												{container.isStacked ? (
													<span className="inline-flex items-center px-3 py-1 text-xs font-semibold text-green-700 bg-green-100 rounded-full">
														Stacked at {container.stackLocation}
													</span>
												) : (
													<span className="inline-flex items-center px-3 py-1 text-xs font-semibold text-yellow-700 bg-yellow-100 rounded-full animate-pulse">
														Pending Stack
													</span>
												)}
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

export default PreviousLanding;
