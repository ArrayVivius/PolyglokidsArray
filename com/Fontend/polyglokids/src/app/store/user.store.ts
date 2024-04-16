import { patchState, signalStore, withMethods, withState } from '@ngrx/signals';

export interface User {
  id: string;
  nombre: string;
  apellido: string;
  rol: string;
  correo: string;
}

type UserState = {
  users: User[]; // Reemplaza 'User' con tu modelo de usuario
  isLoading: boolean;
};

const initialState: UserState = {
  users: [],
  isLoading: false,
};

export const UserStore = signalStore(
  { providedIn: 'root' },
  withState(initialState),
  withMethods(({ users, ...store }) => ({
    addUser(user: User) {
      const updateUser = [...users(), user];
      patchState(store, { users: updateUser });
    },
    removeUse(correo: String) {
      const updateUser = users().filter((user) => user.correo !== correo);
      patchState(store, { users: updateUser });
    },
    actualizat(correo: String, updatedUser: User) {
      const updatedUsers = users().map((user) => {
        if (user.correo === correo) {
          return { ...user, ...updatedUser };
        }
        return user;
      });
      patchState(store, { users: updatedUsers });
    },
  })),
);
