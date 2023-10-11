public class Siren {

    private boolean sirenOn = false;

    public void sirenSound(boolean fire) {
        if (fire) {
            System.out.println("warning fire warning");
        } else {
            System.out.println("Warning burglary warning");
        }
    }
        public boolean getSirenOn () {
            return sirenOn;
        }

        public void setSirenOn ( boolean sirenOn, boolean fire){
            this.sirenOn = sirenOn;
            if (sirenOn) {
                sirenSound(fire);
            }
        }

    }
