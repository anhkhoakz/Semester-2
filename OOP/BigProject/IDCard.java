import java.time.Year;

public class IDCard {
      private int ID;
      private String fullName;
      private String sex;
      private String dateOfBirth;
      private String address;
      private int phoneNumber;

      public IDCard(int ID, String fullName, String sex, String dateOfBirth, String address, int phoneNumber) {
            setID(ID);
            setFullName(fullName);
            setSex(sex);
            setDateOfBirth(dateOfBirth);
            setAddress(address);
            setPhoneNumber(phoneNumber);
      }

      public void setID(int ID) {
            this.ID = ID;
      }

      public void setFullName(String fullName) {
            this.fullName = fullName;
      }

      public void setSex(String sex) {
            this.sex = sex;
      }

      public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
      }

      public void setAddress(String address) {
            this.address = address;
      }

      public void setPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
      }

      public int getID() {
            return ID;
      }

      public String getFullName() {
            return fullName;
      }

      public String getSex() {
            return sex;
      }

      public String getDateOfBirth() {
            return dateOfBirth;
      }

      public String getAddress() {
            return address;
      }

      public int getPhoneNumber() {
            return phoneNumber;
      }

      public int getAge() {
            int currentYear = Year.now().getValue();

            String[] dateOfBirthArr = getDateOfBirth().split("/");
            int birthYear = Integer.parseInt(dateOfBirthArr[2]);

            int ageYear = currentYear - birthYear;

            return ageYear;
      }

      public String toString() {
            return getID() + "," + getFullName() + "," + getSex() + "," + getDateOfBirth() + "," + getAddress() + ","
                        + getPhoneNumber();
      }

}
