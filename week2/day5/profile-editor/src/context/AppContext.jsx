import React, {
  createContext,
  useContext,
  useEffect,
  useReducer,
  useState,
} from "react";

export const AppContext = createContext();

const storedUser = JSON.parse(localStorage.getItem("user"));

const initialState = {
  user: storedUser || { name: "", email: "", about: "" },
};

const userReducer = (state, action) => {
  switch (action.type) {
    case "UPDATE":
      localStorage.setItem("user", JSON.stringify(action.payload));
      return { ...state, user: action.payload };
    case "LOGOUT":
      localStorage.removeItem("user");
      return { ...state, user: { name: "", email: "", about: "" } };
    default:
      return state;
  }
};

export const UserProvider = ({ children }) => {
  const [state, dispatch] = useReducer(userReducer, initialState);

  return (
    <AppContext.Provider value={{ user: state.user, dispatch }}>
      {children}
    </AppContext.Provider>
  );
};
