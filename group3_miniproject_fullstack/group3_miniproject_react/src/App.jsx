import { useState } from "react";
import "./App.css";
import DataCard from "./components/DataCard";
import SearchBar from "./components/SearchBar";
import Button from "./components/Button";
import LoadingSpinner from "./components/LoadingSpinner";
import ErrorMessage from "./components/ErrorMessage";

function App() {
	const [loading, setLoading] = useState(false);
	const [searchValue, setSearchValue] = useState("");
	const [isInvalidId, setIsInvalidId] = useState(true);

	const testData = [
		{
			fullName: "James Martin",
			contactNumber: "09173459821",
			emailAddress: "martinjames@gmail.com",
			location: "Quezon City",
		},
		{
			fullName: "Maria Santos",
			contactNumber: "09286124730",
			emailAddress: "mariasantos@yahoo.com",
			location: "Manila",
		},
		{
			fullName: "John Garcia",
			contactNumber: "09057841236",
			emailAddress: "johngarcia@yahoo.com",
			location: "Pasig City",
		},
		{
			fullName: "Angela Cruz",
			contactNumber: "09984502379",
			emailAddress: "angelacruz@gmail.com",
			location: "Caloocan City",
		},
		{
			fullName: "Robert Johnson",
			contactNumber: "09196238457",
			emailAddress: "robertjohnson@yahoo.com",
			location: "Makati City",
		},
		{
			fullName: "Liza Mendoza",
			contactNumber: "09218354021",
			emailAddress: "lizamendoza@gmail.com",
			location: "Mandaluyong City",
		},
		{
			fullName: "Michael Brown",
			contactNumber: "09364578910",
			emailAddress: "michaelbrown@yahoo.com",
			location: "Valenzuela City",
		},
		{
			fullName: "Alexis Cao",
			contactNumber: "09087612493",
			emailAddress: "alexciscao@gmail.com",
			location: "Parañaque City",
		},
		{
			fullName: "Sophia Reyes",
			contactNumber: "09185234795",
			emailAddress: "sophiareyes@yahoo.com",
			location: "Taguig City",
		},
		{
			fullName: "Daniel Anderson",
			contactNumber: "09276105842",
			emailAddress: "danielanderson@gmail.com",
			location: "Pasay City",
		},
		{
			fullName: "Joshua Villanueva",
			contactNumber: "09068457923",
			emailAddress: "joshuavillanueva@yahoo.com",
			location: "Marikina City",
		},
		{
			fullName: "Camille Fernandez",
			contactNumber: "09972345871",
			emailAddress: "camillefernandez@gmail.com",
			location: "Las Piñas City",
		},
		{
			fullName: "William Davis",
			contactNumber: "09156983740",
			emailAddress: "williamdavis@yahoo.com",
			location: "Antipolo City",
		},
		{
			fullName: "Patrick Bautista",
			contactNumber: "09384265812",
			emailAddress: "patrickbautista@gmail.com",
			location: "Cainta",
		},
		{
			fullName: "Kimberly Ramirez",
			contactNumber: "09073598246",
			emailAddress: "kimberlyramirez@yahoo.com",
			location: "San Juan City",
		},
		{
			fullName: "Ethan Thompson",
			contactNumber: "09234875921",
			emailAddress: "ethanthompson@gmail.com",
			location: "Malabon City",
		},
		{
			fullName: "Hannah Gonzales",
			contactNumber: "09176504329",
			emailAddress: "hannahgonzales@yahoo.com",
			location: "Muntinlupa City",
		},
		{
			fullName: "Christian Navarro",
			contactNumber: "09327851694",
			emailAddress: "christiannavarro@gmail.com",
			location: "Navotas City",
		},
		{
			fullName: "Olivia Walker",
			contactNumber: "09958341207",
			emailAddress: "oliviawalker@yahoo.com",
			location: "Mandaluyong City",
		},
		{
			fullName: "Ryan Lim",
			contactNumber: "09092735486",
			emailAddress: "ryanlim@gmail.com",
			location: "Bacoor City",
		},
		{
			fullName: "Jessica Lee",
			contactNumber: "09265913074",
			emailAddress: "jessicalee@yahoo.com",
			location: "Imus City",
		},
		{
			fullName: "Francis Perez",
			contactNumber: "09134625789",
			emailAddress: "francisperez@gmail.com",
			location: "Dasmariñas City",
		},
		{
			fullName: "Emily Taylor",
			contactNumber: "09318476205",
			emailAddress: "emilytaylor@yahoo.com",
			location: "Cavite City",
		},
		{
			fullName: "Monique Aira",
			contactNumber: "09253098741",
			emailAddress: "mnqaira@gmail.com",
			location: "Trece Martires City",
		},
	];

	function searchCustomerClick(value) {
		setLoading(true);
	}

	function handleButtonClick(){
		setLoading(true);
	}

	return (
		<div className="h-screen lg:h-full w-screen  items-center justify-center font-display">			
			<header className="bg-banner-red text-white text-2xl lg:text-5xl text-center py-10 sticky">
				{" "}
				CUSTOMER DIRECTORY{" "}
			</header>

      {isInvalidId ? (<ErrorMessage message="Invalid Customer ID {insert id}. Please input a valid ID."></ErrorMessage>) : (<></>)}

			<section className="w-3/4 mx-auto my-5">
				<SearchBar
					searchValue={searchValue}
					onClick={searchCustomerClick}
					onChange={setSearchValue}
				/>
			</section>
			
			{loading ? (<LoadingSpinner/>) : (<></>)}

			<section className="flex flex-row gap-3 items-center justify-center my-10">
				<Button 
					text={"SHOW ALL"}
					onClick={handleButtonClick}/>
				<Button
					text={"GET COUNT"}
					onClick={handleButtonClick}/>
				<Button
					text={"RESET"}
					onClick={handleButtonClick}/>
			</section>
			<section className="flex flex-col lg:flex-row lg:flex-wrap gap-5 lg:w-3/4 mx-auto">
				{testData.map((person, index) => (
					<DataCard
						key={index}
						fullName={person.fullName}
						contactNumber={person.contactNumber}
						emailAddress={person.emailAddress}
						location={person.location}
					/>
				))}
			</section>
		</div>
	);
}

export default App;
