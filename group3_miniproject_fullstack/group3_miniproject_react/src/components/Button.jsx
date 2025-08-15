function Button({ text, onClick, buttonClick }) {
	return (
		<>
			{text === "RESET" ? (
				<button className="bg-gray-600 font-bold text-lg text-white px-4 py-2"
				onClick={() => onClick(buttonClick)}>
					{text}
				</button>
			) : (
				<button className="bg-banner-red font-bold text-lg text-white px-4 py-2"
				onClick={() => onClick(buttonClick)}>
					{text}
				</button>
			)}
		</>
	);
}

export default Button;
