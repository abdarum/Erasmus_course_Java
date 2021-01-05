import React, { useContext, useState } from 'react';
import * as Yup from 'yup';
import { Formik, Form  } from 'formik';
import FormSuccess from './../components/FormSuccess';
import FormError from './../components/FormError';
import Label from '../components/common/Label';
import { useTranslation } from "react-i18next";
import FormInput from '../components/FormInput';
import GradientButton from '../components/common/GradientButton';
import { FetchContext } from '../context/FetchContext';

const AccountChangePassword = ({ user }) => {
  const fetchContext = useContext(FetchContext);
  const [saveSuccessAccountChangePassword, setSaveSuccessAccountChangePassword] = useState();
  const [saveErrorAccountChangePassword, setSaveErrorAccountChangePassword] = useState();
  const { t } = useTranslation('common');
  const [saveLoadingAccountChangePassword, setSaveLoadingAccountChangePassword] = useState(false);

  const submitCredentialsAccountChangePassword = async credentials => {
    try {
      setSaveLoadingAccountChangePassword(true);
      const { data } = await fetchContext.authAxios.put(
        `/v1/users/password`,
        credentials
      );
      setSaveLoadingAccountChangePassword(false);
      setSaveSuccessAccountChangePassword(data.message);
      setSaveErrorAccountChangePassword('');
    } catch (error) {
      console.log(error);
      setSaveLoadingAccountChangePassword(false);
      const { data } = error.response;
      setSaveErrorAccountChangePassword(data.message);
      setSaveSuccessAccountChangePassword('');
    }
  };

  const SignupSchema = Yup.object().shape({
    oldPassword: Yup.string().required(t('components.account_change_password_component.forms.validation.password_is_required')),
    newPassword: Yup.string().required(t('components.account_change_password_component.forms.validation.password_is_required')),
    repeatNewPassword: Yup.string().required(t('components.account_change_password_component.forms.validation.password_is_required')).oneOf([Yup.ref('newPassword'), null], t('components.account_change_password_component.forms.validation.passwords_not_mach'))
  });

  return (
    <Formik
      initialValues={{
        oldPassword: '',
        newPassword: '',
        repeatNewPassword: ''
      }}
      onSubmit={values => {
        submitCredentialsAccountChangePassword(values);
      }
      }
      validationSchema={SignupSchema}
    >
      {() => (
        <Form className="mt-4">
          {saveSuccessAccountChangePassword && (
            <FormSuccess text={saveSuccessAccountChangePassword} />
          )}
          {saveErrorAccountChangePassword && (
            <FormError text={saveErrorAccountChangePassword} />
          )}
          <input
            type="hidden"
            name="remember"
            value="true"
          />
          <div>
            <div className="flex">
              <div className="mb-2 mr-2 w-1/2">
                <div className="mb-1">
                  <Label text={t('components.account_change_password_component.forms.data.old_password')} />
                </div>
                <FormInput
                  ariaLabel={t('components.account_change_password_component.forms.data.old_password')}
                  name="oldPassword"
                  type="password"
                  placeholder={t('components.account_change_password_component.forms.data.old_password')}
                />
              </div>
            </div>

            <div className="flex">
              <div className="mb-2 mr-2 w-1/2">
                <div className="mb-1">
                  <Label text={t('components.account_change_password_component.forms.data.new_password')} />
                </div>
                <FormInput
                  ariaLabel={t('components.account_change_password_component.forms.data.new_password')}
                  name="newPassword"
                  type="password"
                  placeholder={t('components.account_change_password_component.forms.data.new_password')}
                />
              </div>
              <div className="mb-2 ml-2 w-1/2">
                <div className="mb-1">
                  <Label text={t('components.account_change_password_component.forms.data.repeat_new_password')} />
                </div>
                <FormInput
                  ariaLabel={t('components.account_change_password_component.forms.data.repeat_new_password')}
                  name="repeatNewPassword"
                  type="password"
                  placeholder={t('components.account_change_password_component.forms.data.repeat_new_password')}
                />
              </div>
            </div>
          </div>

          <div className="flex">
            <div className="mt-2 mb-2">
              <GradientButton
                type="submit"
                text={t('components.account_change_password_component.save_button')}
                loading={saveLoadingAccountChangePassword}
              />
            </div>
          </div>
        </Form>
      )}
    </Formik>

  );
};

export default AccountChangePassword;
