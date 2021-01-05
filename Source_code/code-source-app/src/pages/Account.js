import React, { useContext, useState, useEffect } from 'react';
import PageTitle from '../components/common/PageTitle';
import Card from '../components/common/Card';
import { FetchContext } from '../context/FetchContext';
import { useTranslation } from "react-i18next";
import AccountPersonalData from './../components/AccountPersonalData';
import AccountSensitiveData from './../components/AccountSensitiveData';
import AccountChangePassword from './../components/AccountChangePassword';


const Account = () => {
  const fetchContext = useContext(FetchContext);
  const { t } = useTranslation('common');
  const [userData, setUserData] = useState();

  useEffect(() => {
    const getUserData = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/v1/users'
        );
        setUserData(data.user);
      } catch (err) {
        console.log(err);
      }
    };

    getUserData();
  }, [fetchContext]);

  return (
    <>
      <PageTitle title={t('pages.account_page.title')} />
      <Card>
        <p className="font-bold">{t('pages.account_page.personal_info_section.header')}</p>
        {userData && (
                <AccountPersonalData
                  user={userData}
                />
              )}
      </Card>
      <br />      
      <Card>
        <p className="font-bold">{t('pages.account_page.sensitive_data_section.header')}</p>
        {userData && (
                <AccountSensitiveData
                  user={userData}
                />
              )}
      </Card>
      <br />
      <Card>
        <p className="font-bold">{t('pages.account_page.change_password_section.header')}</p>
        {userData && (
                <AccountChangePassword
                  user={userData}
                />
              )}
      </Card>
    </>
  );
};

export default Account;
