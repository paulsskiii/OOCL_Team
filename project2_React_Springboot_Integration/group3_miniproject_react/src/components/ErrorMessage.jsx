import { MdError } from "react-icons/md";

function ErrorMessage({ message = "Something went wrong" }) {
  return (
    <section
      role="alert"
      aria-live="assertive"
      className="flex items-start gap-3 rounded-md border border-red-300 bg-red-50 px-4 py-3 text-red-700"
    >
      <MdError className="text-red-600 shrink-0" size={20} />
      <p className="text-sm leading-5">
        <span className="font-semibold">Error!</span> {message}
      </p>
    </section>
  );
}

export default ErrorMessage;
