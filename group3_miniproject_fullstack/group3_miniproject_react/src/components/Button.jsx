function Button({ text, onClick }) {
	return (
		<>
			{text === "RESET" ? (
				<button className="bg-gray-400 font-bold text-lg text-gray-700 px-4 py-2">
					{text}
				</button>
			) : (
				<button className="bg-banner-red font-bold text-lg text-red-600 px-4 py-2">
					{text}
				</button>
			)}
		</>
	);
}

export default Button;
