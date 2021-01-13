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
    return initValue.value;
}

export { getCommonNameSelectOptions, getCommonNameDatabaseValues, getPeriodDaysValue };
