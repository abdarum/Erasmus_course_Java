import React, { useContext, useState } from 'react';
import * as Yup from 'yup';
import { Formik, Form, Field } from 'formik';
import FormSuccess from './../components/FormSuccess';
import FormError from './../components/FormError';
import Label from '../components/common/Label';
import { useTranslation } from "react-i18next";
import FormInput from '../components/FormInput';
import GradientButton from '../components/common/GradientButton';
import { FetchContext } from '../context/FetchContext';

const TeacherContactData = ({ user, onChange }) => {
  const fetchContext = useContext(FetchContext);
  const [saveSuccessTeacherContactData, setSaveSuccessTeacherContactData] = useState();
  const [saveErrorTeacherContactData, setSaveErrorTeacherContactData] = useState();
  const { t } = useTranslation('common');
  const [saveLoadingTeacherContactData, setSaveLoadingTeacherContactData] = useState(false);

  const dumpContactInfo = {
    contactInfo: {
      phone: {
        number: "",
        visible: true
      },
      email: {
        email: "",
        visible: true
      },
      // photo: "",
      firstFreeLessonEnable: true,
      description: ""
    }
  };

  const submitCredentialsTeacherContactData = async credentials => {
    try {
      dumpContactInfo.contactInfo.phone.number = credentials.phone;
      dumpContactInfo.contactInfo.phone.visible = credentials.phoneVisible;
      dumpContactInfo.contactInfo.email.email = credentials.email;
      dumpContactInfo.contactInfo.email.visible = credentials.emailVisible;
      dumpContactInfo.contactInfo.firstFreeLessonEnable = credentials.firstFreeLessonEnable;
      dumpContactInfo.contactInfo.description = credentials.description;

      setSaveLoadingTeacherContactData(true);
      const { data } = await fetchContext.authAxios.put(
        `/v1/users`,
        dumpContactInfo
      );
      onChange(data);
      setSaveLoadingTeacherContactData(false);

      setSaveSuccessTeacherContactData(data.message);
      setSaveErrorTeacherContactData('');
    } catch (error) {
      console.log(error);
      setSaveLoadingTeacherContactData(false);
      const { data } = error.response;
      setSaveErrorTeacherContactData(data.message);
      setSaveSuccessTeacherContactData('');
    }
  };

  const SignupSchema = Yup.object().shape({
  });

  return (
    <Formik
      initialValues={{
        email: user.contactInfo ? (user.contactInfo.email ? (user.contactInfo.email.email ? user.contactInfo.email.email : dumpContactInfo.contactInfo.email.email) : user.email) : user.email,
        emailVisible: user.contactInfo ? (user.contactInfo.email ? (user.contactInfo.email.visible !== undefined ? user.contactInfo.email.visible : dumpContactInfo.contactInfo.email.visible) : dumpContactInfo.contactInfo.email.visible) : dumpContactInfo.contactInfo.email.visible,
        phone: user.contactInfo ? (user.contactInfo.phone ? (user.contactInfo.phone.number ? user.contactInfo.phone.number : dumpContactInfo.contactInfo.phone.number) : user.phone) : user.phone,
        phoneVisible: user.contactInfo ? (user.contactInfo.phone ? (user.contactInfo.phone.visible !== undefined ? user.contactInfo.phone.visible : dumpContactInfo.contactInfo.phone.visible) : dumpContactInfo.contactInfo.phone.visible) : dumpContactInfo.contactInfo.phone.visible,
        firstFreeLessonEnable: user.contactInfo ? (user.contactInfo.firstFreeLessonEnable !== undefined ? user.contactInfo.firstFreeLessonEnable : dumpContactInfo.contactInfo.firstFreeLessonEnable) : dumpContactInfo.contactInfo.firstFreeLessonEnable,
        description: user.contactInfo ? (user.contactInfo.description ? user.contactInfo.description : dumpContactInfo.contactInfo.description) : dumpContactInfo.contactInfo.description
      }}
      onSubmit={values => {
        submitCredentialsTeacherContactData(values);
      }
      }
      validationSchema={SignupSchema}
    >
      {({ values }) => (
        <Form className="mt-4">
          {saveSuccessTeacherContactData && (
            <FormSuccess text={saveSuccessTeacherContactData} />
          )}
          {saveErrorTeacherContactData && (
            <FormError text={saveErrorTeacherContactData} />
          )}
          <input
            type="hidden"
            name="remember"
            value="true"
          />
          <div>
            <div className="flex">
              <p className="text-gray-600 text-sm mb-2">{t('components.teacher_contact_data_component.description')}</p>
            </div>
            <div className="flex">
              <div className="mb-2 mr-2 w-1/2">
                <div className="mb-1">
                  <Label text={t('components.teacher_contact_data_component.forms.data.email_address')} />
                </div>
                <FormInput
                  ariaLabel={t('components.teacher_contact_data_component.forms.data.email_address')}
                  name="email"
                  type="email"
                  placeholder={t('components.teacher_contact_data_component.forms.data.email_address')}
                />
              </div>
              <div className="mb-2 ml-2 w-1/2 items-center flex">
                <div className="">
                  <Field type="checkbox" name="emailVisible" />
                </div>
                <div className="ml-2">
                  <Label text={t('components.teacher_contact_data_component.forms.data.email_address_visible')} />
                </div>
                <div className="ml-2">
                  <Label text={`${values.emailVisible}`} />
                </div>
              </div>
            </div>
            <div className="flex">
              <div className="mb-2 mr-2 w-1/2">
                <div className="mb-1">
                  <Label text={t('components.teacher_contact_data_component.forms.data.phone_number')} />
                </div>
                <FormInput
                  ariaLabel={t('components.teacher_contact_data_component.forms.data.phone_number')}
                  name="phone"
                  type="phone"
                  placeholder={t('components.teacher_contact_data_component.forms.data.phone_number')}
                />
              </div>
              <div className="mb-2 ml-2 w-1/2 items-center flex">
                <div className="">
                  <Field type="checkbox" name="phoneVisible" />
                </div>
                <div className="ml-2">
                  <Label text={t('components.teacher_contact_data_component.forms.data.phone_number_visible')} />
                </div>
                <div className="ml-2">
                  <Label text={`${values.phoneVisible}`} />
                </div>
              </div>
            </div>
            <div className="flex mt-2">
              <div className="mb-2 ml-2 w-1/2 items-center flex">
                <div className="">
                  <Field type="checkbox" name="firstFreeLessonEnable" />
                </div>
                <div className="ml-2">
                  <Label text={t('components.teacher_contact_data_component.forms.data.first_free_lesson_enable')} />
                </div>
                <div className="ml-2">
                  <Label text={`${values.firstFreeLessonEnable}`} />
                </div>
              </div>
            </div>
          </div>
          <div className="flex">
            <div className="mb-2 mr-2 w-full">
              <div className="mb-1">
                <Label text={t('components.teacher_contact_data_component.forms.data.description')} />
              </div>
              <Field
                className="border border-gray-300 rounded p-2 w-full mb-2"
                component="textarea"
                name="description"
                placeholder={t('components.teacher_contact_data_component.forms.data.description_placeholder')}
              />
            </div>
          </div>

          <div className="flex">
            <div className="mt-2 mb-2">
              <GradientButton
                type="submit"
                text={t('components.teacher_contact_data_component.save_button')}
                loading={saveLoadingTeacherContactData}
              />
            </div>
          </div>
        </Form>
      )}
    </Formik>

  );
};

export default TeacherContactData;
