function updateStatus(receiptId, status, selectElement) {
    const originalValue = selectElement.dataset.originalValue || selectElement.value;
    fetch(`${contextPath}/all_receipt`, {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded",
        },
        body: `receipt_id=${receiptId}&status=${status}`,
    })
    .then(response => {
        if (!response.ok) {
            alert("Failed to update status");
            selectElement.value = originalValue;
        }else {
            alert("Success to update status");
            selectElement.dataset.originalValue = status;
        }
    })
    .catch(error => {
                    console.error("Error updating status:", error);
                    alert("Error updating status. Please try again.");
                    selectElement.value = originalValue;
    });
}
