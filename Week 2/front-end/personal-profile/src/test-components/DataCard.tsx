type Slide = {
  loading: boolean;
};

export const Content: React.FC<Slide> = ({ loading }) => {
  if (loading == true) {
    return (
      <div className="content">
        <div id="home">
          <p>Fast Learner</p>
          <p>Problem Solver</p>
          <p>Bot Lane Supporter</p>
          <p>Setter and Getter</p>
          <p>Liver Lover</p>
        </div>
        
      </div>
    );
  }
};
