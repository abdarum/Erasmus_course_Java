import React, { useContext, useState, useEffect } from 'react';
import PageTitle from '../components/common/PageTitle';
import Card from '../components/common/Card';
import { AuthContext } from '../context/AuthContext';
import { FetchContext } from '../context/FetchContext';
import { useTranslation } from "react-i18next";
import UserFullDetailsForm from './../components/UserFullDetailsForm';
import AccountChangePassword from './../components/AccountChangePassword';
import qs from 'query-string';


const Account = () => {
  const fetchContext = useContext(FetchContext);
  const auth = useContext(AuthContext);
  const { t } = useTranslation('common');
  const [userData, setUserData] = useState();

  useEffect(() => {
    var queryValues = {
      token: auth.authState.token
    }
    const getUserData = async () => {
      try {
        const { data } = await fetchContext.authAxios.get(
          '/user/' + auth.authState.userInfo.id + '?' + qs.stringify(queryValues)
        );
        setUserData(data);
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
          <UserFullDetailsForm
            user={userData}
            passwordNotVisible
            statusNotEditable
            userTypeNotEditable
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
