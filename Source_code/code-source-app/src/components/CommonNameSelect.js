const getCommonNameSelectOptions = (asyncList, initValue) => {
    const commonNameSelectValuesSelect = [];
    var commonNameSelectSingleValueSelect = {};

    function setStatusSelect() {
        asyncList.forEach(function (entry) {
            if (initValue !== undefined) {
                if (initValue === entry.id) {
                    commonNameSelectSingleValueSelect = { value: `${entry.id}`, label: `${entry.name}` };
                }
            } else {
                commonNameSelectValuesSelect.push({ value: `${entry.id}`, label: `${entry.name}` });
            }
        })
    }

    setStatusSelect();
    if (Object.keys(commonNameSelectSingleValueSelect).length === 0 && commonNameSelectSingleValueSelect.constructor === Object) {
        commonNameSelectSingleValueSelect = undefined;
    }

    return commonNameSelectValuesSelect.length ? commonNameSelectValuesSelect : commonNameSelectSingleValueSelect;
};

const getPeriodDaysValue = (asyncList, initValue) => {
    var commonNameSelectSingleValueSelect = {};

    function setPeriodValue() {
        asyncList.forEach(function (entry) {
            if (initValue !== undefined) {
                if (initValue === entry.id) {
                    commonNameSelectSingleValueSelect = parseInt(entry.period, 10);
                }
            }
        })
    }

    setPeriodValue();

    return commonNameSelectSingleValueSelect;
};

const getCommonNameDatabaseValues = (initValue) => {
    if (initValue) {
        return initValue.value;
    } else {
        return undefined;
    }
}

export { getCommonNameSelectOptions, getCommonNameDatabaseValues, getPeriodDaysValue };
