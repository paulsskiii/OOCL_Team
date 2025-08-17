import { useState, useContext } from "react";
import { UserProfile } from "./UserProfile";
import { Context } from "../App";

type AboutProps = {};

export const About: React.FC<AboutProps> = ({}) => {
	const context = useContext(Context);

	if (!context) return null;

	const { name } = context;
	const { description } = context;
	const { hobbies } = context;
	const { profileModalOpen, setProfileModalOpen } = context;

	return (
		<section className="flex flex-col w-1/2 gap-10">
			<div className="text-2xl font-semibold text-left">
				Hi, I'm <span className="text-violet-300 font-bold">{name}</span>!
			</div>

			<div className="flex flex-col w-full gap-4">
				<div className="text-2xl font-bold text-blue-300">ABOUT ME</div>
				<div className="text-xl text-wrap text-left">{description}</div>
			</div>

			<div className="flex flex-col w-full gap-4">
				<div className="text-2xl font-bold text-green-300">HOBBIES</div>
				<div className="text-xl text-wrap text-left">{hobbies}</div>
			</div>
		</section>
	);
};
