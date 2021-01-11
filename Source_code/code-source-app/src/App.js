import React, { lazy, Suspense, useContext } from 'react';
import {
  BrowserRouter as Router,
  Route,
  Switch,
  Redirect
} from 'react-router-dom';
import './App.css';

import {
  AuthProvider,
  AuthContext
} from './context/AuthContext';
import { FetchProvider } from './context/FetchContext';

import AppShell from './AppShell';

import Home from './pages/Home';
import Login from './pages/Login';
import Signup from './pages/Signup';
import FourOFour from './pages/FourOFour';
import FiveOOne from './pages/FiveOOne';

const Order = lazy(() => import('./pages/Order'));
const FindBooks = lazy(() => import('./pages/FindBooks'));
const Account = lazy(() => import('./pages/Account'));
const Settings = lazy(() => import('./pages/Settings'));
const Readers = lazy(() => import('./pages/Readers'));
const Users = lazy(() => import('./pages/Users'));
const ManageBooks = lazy(() => import('./pages/ManageBooks'));
const ManageOrders = lazy(() => import('./pages/ManageOrders'));

const LoadingFallback = () => (
  <AppShell>
    <div className="p-4">Loading...</div>
  </AppShell>
);

const UnauthenticatedRoutes = () => (
  <Switch>
    <Route path="/login">
      <Login />
    </Route>
    <Route path="/signup">
      <Signup />
    </Route>
    <Route exact path="/">
      <Home />
    </Route>
    <Route path="*">
      <FourOFour />
    </Route>
  </Switch>
);

const AuthenticatedRoute = ({ children, ...rest }) => {
  const auth = useContext(AuthContext);
  return (
    <Route
      {...rest}
      render={() =>
        auth.isAuthenticated() ? (
          <AppShell>{children}</AppShell>
        ) : (
            <Redirect to="/" />
          )
      }
    ></Route>
  );
};

const AdminRoute = ({ children, ...rest }) => {
  const auth = useContext(AuthContext);
  return (
    <Route
      {...rest}
      render={() =>
        auth.isAuthenticated() && auth.isAdmin() ? (
          <AppShell>{children}</AppShell>
        ) : (
            <Redirect to="/" />
          )
      }
    ></Route>
  );
};

const AppRoutes = () => {
  return (
    <>
      <Suspense fallback={<LoadingFallback />}>
        <Switch>
          <AuthenticatedRoute path="/notimplemented">
            <FiveOOne />
          </AuthenticatedRoute>
          <AdminRoute path="/inventory">
            <Order />
          </AdminRoute>
          <AuthenticatedRoute path="/find-books">
            <FindBooks />
          </AuthenticatedRoute>
          <AuthenticatedRoute path="/order">
            <Order />
          </AuthenticatedRoute>
          <AuthenticatedRoute path="/account">
            <Account />
          </AuthenticatedRoute>
          <AuthenticatedRoute path="/settings">
            <Settings />
          </AuthenticatedRoute>
          <AuthenticatedRoute path="/users">
            <Users />
          </AuthenticatedRoute>
          <AuthenticatedRoute path="/readers">
            <Readers />
          </AuthenticatedRoute>
          <AuthenticatedRoute path="/manage-books">
            <ManageBooks />
          </AuthenticatedRoute>
          <AuthenticatedRoute path="/manage-orders">
            <ManageOrders />
          </AuthenticatedRoute>
          <UnauthenticatedRoutes />
        </Switch>
      </Suspense>
    </>
  );
};

function App() {
  return (
    <Router>
      <AuthProvider>
        <FetchProvider>
          <div className="bg-gray-100">
            <AppRoutes />
          </div>
        </FetchProvider>
      </AuthProvider>
    </Router>
  );
}

export default App;
