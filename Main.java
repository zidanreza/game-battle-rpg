import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println ("WELCOME GAME !!!!");
        // Input data karakter Hero
        System.out.print("Enter Hero name: ");
        String heroName = scanner.nextLine();
        System.out.print("Choose Hero class (Knight, Archer, Fighter, Fairy): ");
        String heroClass = scanner.nextLine();
        System.out.print("Enter Hero level: ");
        int heroLevel = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer
        System.out.println ("-----------------------------------");

        // Input data karakter Foe
        System.out.print("Enter Foe name: ");
        String foeName = scanner.nextLine();
        System.out.print("Enter Foe type (Orc, Elf, Dwarf, Skeleton, Goblin, Dragon): ");
        String foeType = scanner.nextLine();
        System.out.print("Enter Foe level: ");
        int foeLevel = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        // Membuat objek Hero berdasarkan kelas yang dipilih
        Hero hero;
        Weapon heroWeapon;
        switch (heroClass.toLowerCase()) {
            case "knight":
                heroWeapon = new Weapon("Sword", 30);
                hero = new Knight(heroName, heroLevel, 150, 100, heroWeapon);
                break;
            case "archer":
                heroWeapon = new Weapon("Arrow", 25);
                hero = new Archer(heroName, heroLevel, 100, 100, heroWeapon);
                break;
            case "fighter":
                heroWeapon = new Weapon("Gloves", 35);
                hero = new Fighter(heroName, heroLevel, 100, 150, heroWeapon);
                break;
            case "fairy":
                heroWeapon = new Weapon("Magic Wand", 20);
                hero = new Fairy(heroName, heroLevel, 100, 200, heroWeapon);
                break;
            default:
                System.out.println("Invalid Hero class. Defaulting to Knight.");
                heroWeapon = new Weapon("Sword", 30);
                hero = new Knight(heroName, heroLevel, 100, 100, heroWeapon);
                break;
        }

        // Membuat objek Foe berdasarkan tipe yang dipilih
        Foe foe;
        switch (foeType.toLowerCase()) {
            case "orc":
                foe = new Orc(foeName, foeLevel, 150, 150);
                break;
            // case "elf":
            //     foe = new Elf(foeName, foeLevel, 200, 100);
            //     break;
            case "dwarf":
                foe = new Dwarf(foeName, foeLevel, 150, 100);
                break;
            case "skeleton":
                foe = new Skeleton(foeName, foeLevel, 150, 200);
                break;
            case "goblin":
                foe = new Goblin(foeName, foeLevel, 100, 150);
                break;
            case "dragon":
                foe = new Dragon(foeName, foeLevel, 200, 100);
                break;
            default:
                System.out.println("Invalid Foe type. Defaulting to Orc.");
                foe = new Orc(foeName, foeLevel, 100, 100);
                break;
        }

        System.out.println(hero.name + " (Level " + hero.level + ", Class: " + hero.race + ") vs " + foe.name + " (Level " + foe.level + ", Type: " + foe.race + ")");
        System.out.println("-----------------------------------");

        while (hero.currentHP > 0 && foe.currentHP > 0) {
            // Pilihan aksi
            System.out.println("Choose action for " + hero.name + ":");
            System.out.println("1. Attack");
            System.out.println("2. Use Skill");
            if (hero instanceof Fairy || hero instanceof Elf) {
                System.out.println("3. Heal");
                if (hero instanceof Elf) {
                    System.out.println("4. Recover");
                }
            }
            System.out.print("Input Action Choose : ");
            int action = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            System.out.println (" ");
            switch (action) {
                case 1:
                    hero.attack(foe);
                    break;
                case 2:
                    hero.useSkill(foe);
                    break;
                    case 3:
                    if (hero instanceof Fairy) {
                        ((Fairy) hero).heal(hero); // Fairy heals herself
                    } else if (hero instanceof Elf) {
                        ((Elf) hero).heal(hero); // Elf heals herself
                    }
                    break;
                case 4:
                    if (hero instanceof Elf) {
                        ((Elf) hero).recover(hero); // Elf recovers herself
                    }
                default:
                    System.out.println("Invalid action. Try again.");
                    continue;
            }

            if (foe.currentHP <= 0) {
                System.out.println(foe.name + " defeated!");
                break;
            }

            foe.attack(hero);
            if (hero.currentHP <= 0) {
                System.out.println(hero.name + " defeated!");
                break;
            }

            foe.useSkill(hero);

            // Output detail pertarungan
            System.out.println(hero.name + " HP: " + hero.currentHP + "/" + hero.maxHP + " | MP: " + hero.currentMP + "/" + hero.maxMP);
            System.out.println(foe.name + " HP: " + foe.currentHP + "/" + foe.maxHP + " | MP: " + foe.currentMP + "/" + foe.maxMP);
            System.out.println("-----------------------------------");

            if (foe.currentHP <= 50 || hero.currentHP <= 50) {
                System.out.println("Do you want to use an item? ");
                System.out.println("1. Potion");
                System.out.println("2. Ether");
                System.out.println("3. Elixir");
                System.out.println("4. No");
                System.out.print("Input Item: ");
                int choose = scanner.nextInt();

                scanner.nextLine(); // Membersihkan buffer
                switch (choose) {
                    case 1:
                        hero.usePotion();
                        break;
                    case 2:
                        hero.useEther();
                        break;
                    case 3:
                        hero.useElixir();
                        break;
                    case 4:
                        continue;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        continue;
                }
            }
        }

        scanner.close();
    }
}