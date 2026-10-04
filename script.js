function showPage(pageId) {
    document.querySelectorAll(".page").forEach(page => {
        page.classList.add("hidden");
    });

    document.getElementById(pageId).classList.remove("hidden");
}

function adminLogin() {
    document.getElementById("adminMessage").innerHTML =
        '<span class="success">Login successful</span>';

    setTimeout(() => {
        showPage("adminPortal");
    }, 700);
}

function doctorLogin() {
    document.getElementById("doctorMessage").innerHTML =
        '<span class="success">Login successful</span>';

    setTimeout(() => {
        showPage("doctorPortal");
    }, 700);
}

function patientLogin() {
    document.getElementById("patientMessage").innerHTML =
        '<span class="success">Login successful</span>';

    setTimeout(() => {
        showPage("patientPortal");
    }, 700);
}

function addDoctor() {

    const name = document.getElementById("doctorName").value;
    const email = document.getElementById("doctorEmail").value;
    const speciality = document.getElementById("doctorSpeciality").value;
    const phone = document.getElementById("doctorPhone").value;

    if (!name || !email || !speciality || !phone) {
        document.getElementById("addDoctorMessage").innerHTML =
            "Please fill all fields.";
        return;
    }

    document.getElementById("addDoctorMessage").innerHTML =
        '<span class="success">Doctor added successfully to Smart Clinic Management System.</span>';
}

function searchDoctor() {

    const name = document.getElementById("searchDoctor").value;

    if (!name) {
        document.getElementById("doctorResult").innerHTML =
            "Please enter a doctor name.";
        return;
    }

    document.getElementById("doctorResult").innerHTML = `
        <div class="doctor-card">
            <h3>Dr. ${name}</h3>
            <p><strong>Speciality:</strong> Cardiology</p>
            <p><strong>Email:</strong> doctor@smartclinic.com</p>
            <p><strong>Phone:</strong> 9876543210</p>
            <p><strong>Available:</strong> Monday - Friday, 10:00 AM - 4:00 PM</p>
        </div>
    `;
}
