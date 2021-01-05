import React, { useContext, useState } from 'react';
import * as Yup from 'yup';
import { Formik, Form } from 'formik';
import FormSuccess from './../components/FormSuccess';
import FormError from './../components/FormError';
import Label from '../components/common/Label';
import { useTranslation } from "react-i18next";
import FormInput from '../components/FormInput';
import GradientButton from '../components/common/GradientButton';
import { FetchContext } from '../context/FetchContext';

const AccountSensitiveData = ({ user }) => {
  const fetchContext = useContext(FetchContext);
  const [saveSuccessAccountSensitiveData, setSaveSuccessAccountSensitiveData] = useState();
  const [saveErrorAccountSensitiveData, setSaveErrorAccountSensitiveData] = useState();
  const { t } = useTranslation('common');
  const [saveLoadingAccountSensitiveData, setSaveLoadingAccountSensitiveData] = useState(false);

  const submitCredentialsAccountSensitiveData = async credentials => {
    try {
      setSaveLoadingAccountSensitiveData(true);
      const { data } = await fetchContext.authAxios.put(
        `/v1/users`,
        credentials
      );
      setSaveLoadingAccountSensitiveData(false);

      setSaveSuccessAccountSensitiveData(data.message);
      setSaveErrorAccountSensitiveData('');
    } catch (error) {
      console.log(error);
      setSaveLoadingAccountSensitiveData(false);
      const { data } = error.response;
      setSaveErrorAccountSensitiveData(data.message);
      setSaveSuccessAccountSensitiveData('');
    }
  };

  const SignupSchema = Yup.object().shape({
    email: Yup.string()
      .email(t('components.account_sensitive_data_info_component.forms.validation.invalid_email'))
      .required(t('components.account_sensitive_data_info_component.forms.validation.email_address_is_required')),
  });

  return (
    <Formik
      initialValues={{
        email: user.email,
        phone: user.phone
      }}
      onSubmit={values => {
        submitCredentialsAccountSensitiveData(values);
      }
      }
      validationSchema={SignupSchema}
    >
      {() => (
        <Form className="mt-4">
          {saveSuccessAccountSensitiveData && (
            <FormSuccess text={saveSuccessAccountSensitiveData+' '+t('components.account_sensitive_data_info_component.some_data_visible_in_page_can_stay_unchanged')} />
          )}
          {saveErrorAccountSensitiveData && (
            <FormError text={saveErrorAccountSensitiveData} />
          )}
          <input
            type="hidden"
            name="remember"
            value="true"
          />
          <div>
            <div className="flex">
              <p class="text-gray-600 text-sm mb-2">{t('components.account_sensitive_data_info_component.description')}</p>
            </div>
            <div className="flex">
              <div className="mb-2 mr-2 w-1/2">
                <div className="mb-1">
                  <Label text={t('components.account_sensitive_data_info_component.forms.data.email_address')} />
                </div>
                <FormInput
                  ariaLabel={t('components.account_sensitive_data_info_component.forms.data.email_address')}
                  name="email"
                  type="email"
                  placeholder={t('components.account_sensitive_data_info_component.forms.data.email_address')}
                />
              </div>
              <div className="mb-2 ml-2 w-1/2">
                <div className="mb-1">
                  <Label text={t('components.account_sensitive_data_info_component.forms.data.phone_number')} />
                </div>
                <FormInput
                  ariaLabel={t('components.account_sensitive_data_info_component.forms.data.phone_number')}
                  name="phone"
                  type="phone"
                  placeholder={t('components.account_sensitive_data_info_component.forms.data.phone_number')}
                />
              </div>
            </div>
          </div>

          <div className="flex">
            <div className="mt-2 mb-2">
              <GradientButton
                type="submit"
                text={t('components.account_sensitive_data_info_component.save_button')}
                loading={saveLoadingAccountSensitiveData}
              />
            </div>
          </div>
        </Form>
      )}
    </Formik>

  );
};

export default AccountSensitiveData;
