
function map (idbranch) {
    console.log(idbranch);
    const address = document.getElementById("map");
    if(idbranch === 1){
        address.innerHTML = `<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3550.6693199927936!2d105.78484157504248!3d20.980912980656452!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135accdd8a1ad71%3A0xa2f9b16036648187!2zSOG7jWMgdmnhu4duIEPDtG5nIG5naOG7hyBCxrB1IGNow61uaCB2aeG7hW4gdGjDtG5n!5e1!3m2!1svi!2s!4v1730561163746!5m2!1svi!2s" ></iframe>`
    }
    if(idbranch === 2){
        address.innerHTML = `<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3549.64043500314!2d105.8553285750438!3d21.024165080623987!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135abebf87e0011%3A0x647af200da508d2b!2zTmjDoCBow6F0IEzhu5tuIEjDoCBO4buZaQ!5e1!3m2!1svi!2s!4v1730561236361!5m2!1svi!2s" ></iframe>`
    }
    if(idbranch === 3){
        address.innerHTML = `<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d28390.667384883!2d105.80322225926051!3d21.058030758282985!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135aafe7260066b%3A0x4c2c988309aaa3db!2zSOG7kyBUw6J5!5e1!3m2!1svi!2s!4v1730559228205!5m2!1svi!2s" ></iframe>`
    }
    if(idbranch === 4){
        address.innerHTML = `<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1774.9010995876945!2d105.78273733859736!3d21.017370495157273!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x313454ab43c0c4db%3A0xdb6effebd6991106!2sKeangnam%20Landmark%2072!5e1!3m2!1svi!2s!4v1730561281196!5m2!1svi!2s" ></iframe>`
    }
}

