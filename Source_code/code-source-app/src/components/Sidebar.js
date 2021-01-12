import React, { useContext } from 'react';
import classNames from 'classnames';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  faBook,
  faBookOpen,
  faBookReader,
  faEdit,
  faTasks,
  faList,
  faAddressCard,
  faCogs,
  faUsersCog
} from '@fortawesome/free-solid-svg-icons';
import { Link, useLocation } from 'react-router-dom';
import logo from './../images/logo.png';
import { AuthContext } from './../context/AuthContext';
import { useTranslation } from "react-i18next";

var admin = 1;
var librarian = 2;
var reader = 3;

const navItems = [
  {
    label: 'components.sidebar_component.link_label.find_books',
    path: 'find-books',
    icon: faBook,
    allowedRoles: [reader, librarian]
  },
  {
    label: 'components.sidebar_component.link_label.orders',
    path: 'manage-orders',
    icon: faBookOpen,
    allowedRoles: [reader]
  },
  {
    label: 'components.sidebar_component.link_label.manage_books',
    path: 'manage-books',
    icon: faEdit,
    allowedRoles: [librarian]
  },
  {
    label: 'components.sidebar_component.link_label.manage_orders',
    path: 'manage-orders',
    icon: faTasks,
    allowedRoles: [librarian]
  },
  {
    label: 'components.sidebar_component.link_label.all_users',
    path: 'users',
    icon: faUsersCog,
    allowedRoles: [admin]
  },
  {
    label: 'components.sidebar_component.link_label.readers',
    path: 'readers',
    icon: faBookReader,
    allowedRoles: [admin, librarian]
  },
  {
    label: 'components.sidebar_component.link_label.reports',
    path: 'notimplemented',
    icon: faList,
    allowedRoles: [admin]
  },
  {
    label: 'components.sidebar_component.link_label.account',
    path: 'account',
    icon: faAddressCard,
    allowedRoles: [reader,  librarian, admin]
  },
  {
    label: 'components.sidebar_component.link_label.settings',
    path: 'settings',
    icon: faCogs,
    allowedRoles: []
  }
];

const NavItem = ({ navItem }) => {
  const { t  } = useTranslation('common');
  const location = useLocation();
  const isCurrentRoute =
    location.pathname === `/${navItem.path}`;
  const classes = classNames({
    'px-2 sm:px-6 justify-center sm:justify-start py-3 rounded-full flex': true,
    'text-gray-600 hover:text-blue-500 transform hover:translate-x-1 transition ease-in-out duration-100': !isCurrentRoute,
    'bg-gradient text-gray-100 shadow-lg': isCurrentRoute
  });
  return (
    <Link to={navItem.path} className={classes}>
      <div className="flex items-center">
        <div className="mr-0 sm:mr-4">
          <FontAwesomeIcon icon={navItem.icon} />
        </div>
        <span className="hidden sm:block">
          {t(navItem.label)}
        </span>
      </div>
    </Link>
  );
};

const NavItemContainer = ({ children }) => (
  <div>{children}</div>
);

const Sidebar = () => {
  const auth = useContext(AuthContext);
  const { userTypeId } = auth.authState.userInfo;
  return (
    <section className="h-screen">
      <div className="w-16 sm:w-24 m-auto">
        <img src={logo} rel="logo" alt="Logo" />
      </div>
      <div className="mt-20">
        {navItems.map((navItem, i) => (
          <NavItemContainer key={i}>
            {navItem.allowedRoles.includes(userTypeId) && (
              <NavItem navItem={navItem} />
            )}
          </NavItemContainer>
        ))}
      </div>
    </section>
  );
};

export default Sidebar;
