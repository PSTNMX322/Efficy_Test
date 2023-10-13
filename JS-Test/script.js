// JavaScript starting skeleton, including the Opportunity status data
const oppoStatus = [
    {
        "K_OPPO_STATUS": 1,
        "STATUS": "1. Initial Contact",
        "SUCCESS": 0,
    },
    {
        "K_OPPO_STATUS": 2,
        "STATUS": "2. Demonstration",
        "SUCCESS": 25,
    },
    {
        "K_OPPO_STATUS": 3,
        "STATUS": "3. Proposal",
        "SUCCESS": 50,
    },
    {
        "K_OPPO_STATUS": 4,
        "STATUS": "4. Negotiation",
        "SUCCESS": 75,
    },
    {
        "K_OPPO_STATUS": 5,
        "STATUS": "5. Order",
        "SUCCESS": 100,
    },
];

const FormComponent = class {
    constructor() {
        // Selecting all useful elements to populate the view
        this.select = document.querySelector('select');
        this.input = document.querySelector('input');
        this.form = document.querySelector('form');
        this.output= document.querySelector('.output');

        // Adding event listeners to modify and update the elements
        // (binding functions to "this" to keep the same instance of "this")
        this.select.addEventListener('change', this.onOptionChange.bind(this));
        this.form.addEventListener('submit', this.submitFunction.bind(this));
    }

    start() {
        // Iterating on Oppo Status list and populating select
        for (let status of oppoStatus) {
            let option = document.createElement('option');
            option.value = status.K_OPPO_STATUS;
            option.text = status.STATUS;
            this.select.appendChild(option)
        }
    }

    onOptionChange() {
        // On select change, iterating on Oppo Status list to find the corresponding text
        const selectedStatus = parseInt(this.select.value);
        for (let status of oppoStatus){
            if(status.K_OPPO_STATUS === selectedStatus){
                this.input.value = status.SUCCESS
            }
        }
    }

    submitFunction(e) {
        // Preventing the submit to refresh the page and losing the data containing in "this" instance
        e.preventDefault();

        // Formatting response and displaying it
        let jsonData = {
            status: parseInt(this.select.value),
            success: parseInt(this.input.value),
        };
        this.output.textContent = JSON.stringify(jsonData);
    }
};

const fc = new FormComponent();
fc.start();
