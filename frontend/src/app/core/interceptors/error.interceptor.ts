import { HttpErrorResponse, HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { DialogErrorService } from '../../shared/services/dialog-error.service';
import { catchError, pipe, throwError } from 'rxjs';

export const errorInterceptor: HttpInterceptorFn = (req, next) => {
  const dialogErrorService = inject(DialogErrorService);

  return next(req).pipe(
    catchError((error: HttpErrorResponse) => {
      let message = 'An unxcepected error occurred';
      let details = '';

      if (error.error?.message){
        message = error.error.message;
      }

      if (error.status){
        details = `Status: ${error.status} - ${error.statusText}`;
      }

      dialogErrorService.openErrorDialog(message, 'Error', details);

      return throwError(() => error);
    })
  );
};
