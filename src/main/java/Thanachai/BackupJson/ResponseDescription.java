package Thanachai.BackupJson;


    public class ResponseDescription <เพิ่มรายการสำเร็จ, success> {
        private String status;
        private String description;

        public ResponseDescription(String status, String description) {
            this.status = status;
            this.description = description;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        {

        }

        @Override
        public String toString() {
            return "ResponseDescription{" +
                    "status='" + status + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

