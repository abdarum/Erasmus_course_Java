import React, { createContext, useState } from 'react';
import { useHistory } from 'react-router-dom';

const AuthContext = createContext();
const { Provider } = AuthContext;

const AuthProvider = ({ children }) => {
  const history = useHistory();

  const token = localStorage.getItem('token');
  const userInfo = localStorage.getItem('userInfo');

  const [authState, setAuthState] = useState({
    token,
    userInfo: userInfo ? JSON.parse(userInfo) : {}
  });

  const setAuthInfo = ({ token, userInfo }) => {
    localStorage.setItem('token', token);
    localStorage.setItem(
      'userInfo',
      JSON.stringify(userInfo)
    );

    setAuthState({
      token,
      userInfo
    });
  };

  const logout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('userInfo');
    setAuthState({});
    history.push('/login');
  };

  const isAuthenticated = () => {
    if (!authState.token) {
      return false;
    }
    return true;
  };

  const isAdmin = () => {
    return authState.userInfo.userTypeId === getAdminUserTypeId();
  };

  const isLibrarian = () => {
    return authState.userInfo.userTypeId === getLibrarianUserTypeId();
  };

  const getAdminUserTypeId = () => {
    return 1;
  };
  
  const getLibrarianUserTypeId = () => {
    return 2;
  };

  const getReaderUserTypeId = () => {
    return 3;
  };

  return (
    <Provider
      value={{
        authState,
        setAuthState: authInfo => setAuthInfo(authInfo),
        logout,
        isAuthenticated,
        isAdmin,
        isLibrarian
      }}
    >
      {children}
    </Provider>
  );
};

export { AuthContext, AuthProvider };
