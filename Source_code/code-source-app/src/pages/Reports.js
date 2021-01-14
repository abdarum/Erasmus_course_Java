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
import { useHistory } from 'react-router-dom';


const Reports = () => {
  const auth = useContext(AuthContext);
  const { t } = useTranslation('common');
  const history = useHistory();

  useEffect(() => {
  }, []);


  return (
    <>
      <PageTitle title={t('pages.reports_page.title')} />
      <Card>
        <p className="font-bold">{t('pages.reports_page.submitted_section.header')}</p>
        <button onClick={() => { history.push('/inventory/submitted') }}><p>{t('pages.reports_page.get_report_button')}</p></button>
      </Card>
      <br />
      <Card>
        <p className="font-bold">{t('pages.reports_page.books_section.header')}</p>
        <button onClick={() => { history.push('/inventory/books') }}><p>{t('pages.reports_page.get_report_button')}</p></button>
      </Card>
      <br />
      <Card>
        <p className="font-bold">{t('pages.reports_page.users_section.header')}</p>
        <button onClick={() => { history.push('/inventory/users') }}><p>{t('pages.reports_page.get_report_button')}</p></button>
      </Card>
      <br />
      <Card>
        <p className="font-bold">{t('pages.reports_page.userrating_section.header')}</p>
        <button onClick={() => { history.push('/inventory/userrating') }}><p>{t('pages.reports_page.get_report_button')}</p></button>
      </Card>
    </>
  );
};

export default Reports;
