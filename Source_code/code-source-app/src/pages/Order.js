import React, {
  useContext,
  useEffect,
  useState
} from 'react';
import PageTitle from '../components/common/PageTitle';
import { FetchContext } from '../context/FetchContext';
import Card from '../components/common/Card';
import OrderForm from '../components/OrderForm';
import DangerButton from '../components/common/DangerButton';
import FormError from '../components/FormError';
import FormSuccess from '../components/FormSuccess';
import qs from 'query-string';
import { AuthContext } from '../context/AuthContext';


const Order = () => {
  const fetchContext = useContext(FetchContext);
  const [order, setOrder] = useState();
  const [successMessage, setSuccessMessage] = useState();
  const [errorMessage, setErrorMessage] = useState();
  const auth = useContext(AuthContext);

  return (
    <>
      <PageTitle title="Order" />
      {/* {order ? (
        <></>
      ) : ( */}
      <Card>
        <OrderForm
          orderItem={order}
          librarianMode={auth.isLibrarian()}
        />
      </Card>
      {/* )} */}

    </>
  );
};

export default Order;
