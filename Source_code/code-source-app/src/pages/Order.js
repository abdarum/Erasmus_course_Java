import React, {
  useContext,
  useEffect,
  useState
} from 'react';
import PageTitle from '../components/common/PageTitle';
import { FetchContext } from '../context/FetchContext';
import Card from '../components/common/Card';
import OrderForm from '../components/OrderForm';
import { useTranslation } from "react-i18next";
import { AuthContext } from '../context/AuthContext';


const Order = () => {
  const auth = useContext(AuthContext);
  const { t } = useTranslation('common');

  useEffect(() => {
  }, []);


  return (
    <>
      <PageTitle title={t('pages.order_page.title')} />
      <Card>
        <OrderForm
          librarianMode={auth.isLibrarian()}
        />
      </Card>
    </>
  );
};

export default Order;
