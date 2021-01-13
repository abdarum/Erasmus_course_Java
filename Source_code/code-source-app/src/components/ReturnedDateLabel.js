import React, { useEffect, useContext, useState } from 'react';
import { getPeriodDaysValue } from './CommonNameSelect';
import { useTranslation } from "react-i18next";

const ReturnedDateLabel = ({
    borrowedDate,
    borrowPeriodsRawList,
    periodId
}) => {
    Date.prototype.addDays = function (days) {
        let date = new Date(this.valueOf());
        date.setDate(date.getDate() + days);
        return date;
    };

    const { t } = useTranslation('common');
    const periodValue = getPeriodDaysValue(borrowPeriodsRawList, periodId);
    const nowValue = new Date();
    const borrowedDateValue = new Date(borrowedDate.valueOf());
    const threeDaysToReturn = borrowedDateValue.addDays(periodValue - 3);
    const returnDate = borrowedDateValue.addDays(periodValue);

    const diffValue = returnDate.getDate() - borrowedDateValue.getDate();

    return (
        <>
            { returnDate && threeDaysToReturn && borrowedDateValue ? (
                <div className="text-xl">
                    {nowValue.getTime() > returnDate.getTime() ? (<p className="text-red-600">{t('components.returned_date_label_component.delayed')}</p>) : (
                        nowValue.getTime() > threeDaysToReturn.getTime() ? (<p className="text-yellow-600">{t('components.returned_date_label_component.left_only')+diffValue}</p>) : (<p className="text-green-600">{t('components.returned_date_label_component.days_to_deadline')+diffValue}</p>)
                    )}
                </div >
            ) : (
                    <> </>
                )}
        </>
    );
};

export default ReturnedDateLabel;
