import { useState, useEffect } from "react";
import "./App.css";
import DataCard from "./components/DataCard";
import SearchBar from "./components/SearchBar";
import Button from "./components/Button";
import LoadingSpinner from "./components/LoadingSpinner";
import ErrorMessage from "./components/ErrorMessage";
import {
 getAllCustomers,
 getCustomerCount,
 getCustomerById,
} from "./fetcher/DataFetcher";

function App() {
 const [loading, setIsLoading] = useState(false);
 const [searchValue, setSearchValue] = useState("");
 const [testData, setTestData] = useState([]);
 const [isInvalidId, setIsInvalidId] = useState(false);
useEffect(() => {
  const timer = setTimeout(() => {
            setIsLoading(false); 
        }, 3000);
        return () => clearTimeout(timer);
    }, [loading]);

 function fetchAllCustomers(){
  getAllCustomers().then((response) => {
   setTestData(response.data);
  })
  .catch((error) => {
  console.error(error);
 });
 }

 function fetchCustomerCount(){
  getCustomerCount().then((response) => {
	console.log(response)
   alert("There are " + response.data + " customers");
  })
  .catch((error) => {
  console.error(error);
 });
 }
 
 function fetchCustomerById(id){
  if(id){
   getCustomerById().then((response) => {
    setTestData(response.data);
   })
   .catch((error) => {
   console.error(error);
  });
 }
 }

 function searchCustomerClick(value) {
  setIsLoading(true);
  fetchCustomerById(value)
  setIsLoading(true);
 }

 function handleAllButtonClick(){
  setIsLoading(true);
  fetchAllCustomers();
 }

 function handleButtonClick(){
  setTestData([]);
 }
 function handleCountButtonClick(){
  setIsLoading(true);
  fetchCustomerCount();
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
					value={searchValue}
				/>
			</section>
			
			{loading ? (<LoadingSpinner/>) : (<></>)}

			<section className="flex flex-row gap-3 items-center justify-center my-10">
				<Button 
					text={"SHOW ALL"}
					onClick={handleAllButtonClick}/>
				<Button
					text={"GET COUNT"}
					onClick={handleCountButtonClick}/>
				<Button
					text={"RESET"}
					onClick={handleButtonClick}/>
			</section>
			<section className="flex flex-col lg:flex-row lg:flex-wrap gap-5 lg:w-3/4 mx-auto lg:h-145">
				{testData.map((person, index) => (
					<DataCard
						key={index}
						fullName={person.firstName + " " + person.lastName}
						contactNumber={person.contactNumber}
						emailAddress={person.emailAddress}
						location={person.city}
					/>
				))}
			</section>
		</div>
	);
}

export default App;
