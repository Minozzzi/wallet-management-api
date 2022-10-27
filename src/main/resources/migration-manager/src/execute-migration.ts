import { migrations } from "./migrations";

migrations.forEach(async (migration) => {
  await import(`./migrations/${migration}`);
});
