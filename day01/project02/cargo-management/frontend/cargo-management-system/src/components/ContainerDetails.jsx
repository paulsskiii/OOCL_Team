import React from "react";
import { useParams } from "react-router";

const ContainerDetails = () => {
  const { id } = useParams();

  console.log(id);

  return <div>ContainerDetails By {id}</div>;
};

export default ContainerDetails;
