type Banner = {
  name: string;
  quote: string;
};

export const Banner: React.FC<Banner> = ({name, quote}) => {
  return (
    <div className="banner">
      <h1>{name}</h1>
      <blockquote>
        {quote}
      </blockquote>
    </div>
  );
}