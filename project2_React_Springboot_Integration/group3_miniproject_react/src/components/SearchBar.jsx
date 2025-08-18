import { useState } from "react";
import { CiSearch } from "react-icons/ci";

function SearchBar({ onClick, onChange, searchValue }) {
	return (
		<div
			className={
				"cursor-pointer bg-white px-1.5 py-0.5 font-medium rounded-full shadow-sm hover: placeholder:text-gray-200 flex flex-row transition-all border-2 border-gray-400"
			}
		>
			{/* search icon */}
			<CiSearch
				size={28}
				color="#959595"
				className="transition-all hover:cursor-pointer"
				strokeWidth={1}
				onClick={() => onClick(searchValue)}
			/>
			{/* vertical line separator */}
			<div className="mx-2 my-0.5 border-r border-gray-300" />
			{/* input field */}

			<input
				className="w-full text-gray-500 bg-transparent rounded-r-full focus:outline-none text-lg"
				type="search"
				value={searchValue}
				placeholder={"Input Customer ID"}
				onChange={(e) => {
					onChange(e.target.value);
				}}
			/>
		</div>
	);
}

export default SearchBar;
