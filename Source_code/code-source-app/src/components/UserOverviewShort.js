import React, { useEffect, useContext } from 'react';
import { useTranslation } from "react-i18next";
import { getAuthorSelectOptions, getAuthorDatabaseValues } from './AuthorSelect';
import { getCommonNameSelectOptions, getCommonNameDatabaseValues } from './CommonNameSelect';
import { useHistory } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';
import qs from 'query-string';

const UserOverviewShort = ({
  userItem
}) => {
  const { t } = useTranslation('common');
  const history = useHistory();
  const authContext = useContext(AuthContext);

  useEffect(() => {
    // console.log(userItem);
  }, []);

  const dumpUserInfo = {
    id: null,
    firstName: '',
    lastName: '',
    status: 'active',
    userTypeId: '',
    phone: '',
    email: '',
    password: '',
    birthdate: '',
    gender: '',
    address: '',
    city: ''
  };

  return (
    <div>
      <div className="flex items-center justify-between mb-2">
        <div className="">
          <p className="font-bold">{userItem.firstName} {userItem.lastName}</p>
        </div>
        <div className="flex">
          <p className="text-gray-600 text-sm rounded border border-blue-600 px-2">{userItem.status}</p>
        </div>
      </div >
      <div className="flex items-center justify-between">
        <div className="flex items-center">
          <p className="text-gray-600 text-base text-left mr-1">{t('components.user_overview_short_component.labels.phone')} </p>
          <p className="text-gray-600 text-base text-left">{userItem.phone} </p>
        </div>
        <div className="flex items-center">
          <p className="text-gray-600 text-base text-left mr-1">{t('components.user_overview_short_component.labels.email')} </p>
          <p className="text-gray-600 text-base text-left">{userItem.email} </p>
        </div>
      </div>
      <div className="flex items-center justify-between">
        <div className="flex items-center">
          <p className="text-gray-600 text-base text-left mr-1">{t('components.user_overview_short_component.labels.birthdate')} </p>
          <p className="text-gray-600 text-base text-left">{userItem.birthdate} </p>
        </div>
        <div className="flex items-center">
          <p className="text-gray-600 text-base text-left mr-1">{t('components.user_overview_short_component.labels.city')} </p>
          <p className="text-gray-600 text-base text-left">{userItem.city} </p>
        </div>
        <div className="flex items-center">
          <p className="text-gray-600 text-base text-left mr-1">{t('components.user_overview_short_component.labels.address')} </p>
          <p className="text-gray-600 text-base text-left">{userItem.address} </p>
        </div>
      </div>
    </div >

  );
};

export default UserOverviewShort;
