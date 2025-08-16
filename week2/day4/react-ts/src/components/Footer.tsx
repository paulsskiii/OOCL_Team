const Footer = () => {
    return (
        <footer
            className="flex flex-col items-center bg-zinc-50 text-center text-surface dark:bg-neutral-700 dark:text-white lg:text-left">
            <div className="container p-6">
                <div className="grid gap-4 lg:grid-cols-2">
                    <div className="mb-6 md:mb-0">
                        <h5 className="mb-2 font-medium uppercase">Footer text</h5>

                        <p className="mb-4">
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Iste
                            atque ea quis molestias. Fugiat pariatur maxime quis culpa
                            corporis vitae repudiandae aliquam voluptatem veniam, est atque
                            cumque eum delectus sint!
                        </p>
                    </div>

                    <div className="mb-6 md:mb-0">
                        <h5 className="mb-2 font-medium uppercase">Footer text</h5>

                        <p className="mb-4">
                            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Iste
                            atque ea quis molestias. Fugiat pariatur maxime quis culpa
                            corporis vitae repudiandae aliquam voluptatem veniam, est atque
                            cumque eum delectus sint!
                        </p>
                    </div>
                </div>
            </div>

            <div className="w-full bg-black/5 p-4 text-center">
                © 2023 Copyright:
                <a href="https://facebook.com/"> Pesbok</a>
            </div>
        </footer>
    )
}

export default Footer