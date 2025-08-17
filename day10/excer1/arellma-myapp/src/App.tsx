import "./App.css";
import React, { useState, useContext, createContext } from "react";
import { HomePage } from "./components/HomePage";

type ContextType = {
	userName: string;
	setUsername: React.Dispatch<React.SetStateAction<string>>;
	signedIn: boolean;
	setIsSignedIn: React.Dispatch<React.SetStateAction<boolean>>;
	name: string;
	setName: React.Dispatch<React.SetStateAction<string>>;
	email: string;
	setEmail: React.Dispatch<React.SetStateAction<string>>;
	description: string;
	setDescription: React.Dispatch<React.SetStateAction<string>>;
	hobbies: string;
	setHobbies: React.Dispatch<React.SetStateAction<string>>;
	profileModalOpen: boolean;
	setProfileModalOpen: React.Dispatch<React.SetStateAction<boolean>>;
	loginModalOpen: boolean;
	setLoginModalOpen: React.Dispatch<React.SetStateAction<boolean>>;
};

export const Context = React.createContext<ContextType | null>(null);

function App() {
	debugger;
	const [userName, setUsername] = useState("Guest");
	const [signedIn, setIsSignedIn] = useState(false);
	const [name, setName] = useState("Martin James Arellano");
	const [email, setEmail] = useState("martinjamesarellano@gmail.com");
	const [description, setDescription] = useState(
		"Hi! I am currently a Programmer from OOCL, focusing on full-stack development. I am proficient in ReactJs, NextJS, and TailwindCSS for frontend, then Spring Boot, NodeJS for the backend."
	);
	const [hobbies, setHobbies] = useState(
		"I like to play videogames like Helldivers 2, League of Legends, Genshin Impact and Honkai Star Rail. Also like to go jogging sometimes and build keyboards :)"
	);
	const [profileModalOpen, setProfileModalOpen] = useState(false);
	const [loginModalOpen, setLoginModalOpen] = useState(false);

	return (
		<Context.Provider
			value={{
				userName,
				setUsername,
				signedIn,
				setIsSignedIn,
				name,
				setName,
				email,
				setEmail,
				description,
				setDescription,
				hobbies,
				setHobbies,
				profileModalOpen,
				setProfileModalOpen,
				loginModalOpen,
				setLoginModalOpen,
			}}
		>
			<HomePage />
		</Context.Provider>
	);
}

export default App;
