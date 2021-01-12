import React from 'react';
import { useField } from 'formik';
import FormError from './../components/common/FormError';
import Input from './../components/common/Input';

const FormInput = ({
  ariaLabel,
  name,
  type,
  placeholder,
  onClick,
  disabled
}) => {
  const [field, meta] = useField(name);
  return (
    <>
      <Input
        field={field}
        ariaLabel={ariaLabel}
        name={field.name}
        type={type}
        placeholder={placeholder}
        onClick={onClick}
        disabled={disabled}
      />
      {meta.touched && meta.error ? (
        <FormError text={meta.error}></FormError>
      ) : null}
    </>
  );
};

export default FormInput;
